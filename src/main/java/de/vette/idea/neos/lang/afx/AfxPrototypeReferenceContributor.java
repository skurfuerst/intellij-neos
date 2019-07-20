package de.vette.idea.neos.lang.afx;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.PsiReferenceRegistrar;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.ProcessingContext;
import de.vette.idea.neos.lang.fusion.psi.FusionPrototypeSignature;
import de.vette.idea.neos.lang.fusion.resolve.ref.AfxFusionPrototypeReference;
import de.vette.idea.neos.lang.fusion.resolve.ref.FusionPrototypeInstanceReference;
import de.vette.idea.neos.lang.fusion.stubs.index.FusionPrototypeDeclarationIndex;
import org.jetbrains.annotations.NotNull;
import org.picocontainer.defaults.SimpleReference;

import java.util.Collection;

public class AfxPrototypeReferenceContributor extends com.intellij.psi.PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(XmlPatterns.xmlTag(),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                 @NotNull ProcessingContext
                                                                         context) {
                        XmlTag tag = (XmlTag) element;
                        String key = tag.getName();
                        if (tag.getName().contains(":")) {
                            return new PsiReference[]{
                                    new AfxFusionPrototypeReference(tag)
                            };
                        } else {
                            return PsiReference.EMPTY_ARRAY;
                        }


                    }
                }, PsiReferenceRegistrar.HIGHER_PRIORITY);
    }
}
