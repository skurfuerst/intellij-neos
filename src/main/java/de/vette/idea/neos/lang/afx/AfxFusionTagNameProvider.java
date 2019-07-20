package de.vette.idea.neos.lang.afx;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.XmlTagNameProvider;
import de.vette.idea.neos.NeosProjectComponent;
import de.vette.idea.neos.lang.fusion.resolve.ResolveEngine;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AfxFusionTagNameProvider implements XmlTagNameProvider {
    @Override
    public void addTagNameVariants(List<LookupElement> elements, @NotNull XmlTag tag, String prefix) {
        ResolveEngine.getPrototypeDefinitions()
        NeosProjectComponent.getLogger().warn("TAGNAMEVAR" + prefix + "::" + tag.getName());
        //LookupElementBuilder.create()

    }
}
