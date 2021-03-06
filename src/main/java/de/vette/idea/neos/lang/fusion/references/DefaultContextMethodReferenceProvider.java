/*
 *  IntelliJ IDEA plugin to support the Neos CMS.
 *  Copyright (C) 2016  Christian Vette
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.vette.idea.neos.lang.fusion.references;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ProcessingContext;
import com.intellij.util.indexing.FileBasedIndex;
import de.vette.idea.neos.indexes.DefaultContextFileIndex;
import de.vette.idea.neos.lang.fusion.psi.FusionCompositeIdentifier;
import de.vette.idea.neos.lang.fusion.psi.FusionMethodCall;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DefaultContextMethodReferenceProvider extends PsiReferenceProvider {

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
        List<PsiReference> references = new ArrayList<PsiReference>();
        PsiElement parentElement = psiElement.getParent();
        if (parentElement != null && parentElement instanceof FusionMethodCall) {
            if (parentElement.getPrevSibling() != null && parentElement.getPrevSibling().getPrevSibling() != null) {
                PsiElement compositeElement = parentElement.getPrevSibling().getPrevSibling();
                if (compositeElement instanceof FusionCompositeIdentifier) {
                    String value = compositeElement.getText();
                    List<String> helpers = FileBasedIndex.getInstance().getValues(DefaultContextFileIndex.KEY, value, GlobalSearchScope.allScope(psiElement.getProject()));
                    for (String helper : helpers) {
                        references.add(new DefaultContextMethodReference(psiElement, helper, psiElement.getText()));
                    }
                    return references.toArray(new PsiReference[helpers.size()]);
                }
            }
        }
        return new PsiReference[0];
    }
}
