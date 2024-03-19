package org.openmrs.module.cfldistributionship.metadata;

import org.openmrs.api.FormService;
import org.openmrs.api.context.Context;
import org.openmrs.module.htmlformentry.HtmlFormEntryService;
import org.openmrs.module.htmlformentryui.HtmlFormUtil;
import org.openmrs.module.metadatadeploy.bundle.VersionedMetadataBundle;
import org.openmrs.ui.framework.resource.ResourceFactory;

import java.util.Arrays;
import java.util.List;

/** Loads all HTML forms from `omod/src/main/webapp/resources/htmlforms`. */
public class HtmlFormsMetadata extends VersionedMetadataBundle {

  @Override
  public int getVersion() {
    return 2;
  }

  @Override
  protected void installEveryTime() {
    // nothing to do
  }

  @Override
  protected void installNewVersion() throws Exception {
    final ResourceFactory resourceFactory = ResourceFactory.getInstance();
    final FormService formService = Context.getFormService();
    final HtmlFormEntryService htmlFormEntryService =
        Context.getService(HtmlFormEntryService.class);

    final List<String> htmlforms =
        Arrays.asList(
            "cfldistribution-ship:htmlforms/cfl-hiv-intake.xml",
            "cfldistribution-ship:htmlforms/cfl-medicine-refill.xml",
            "cfldistribution-ship:htmlforms/cfl-medical-visit-note.xml",
            "cfldistribution-ship:htmlforms/cfl-migrated-medical-history.xml",
            "cfldistribution-ship:htmlforms/cfl-migrated-lab-result.xml",
            "cfldistribution-ship:htmlforms/cfl-migrated-tb-data.xml");

    for (String htmlform : htmlforms) {
      HtmlFormUtil.getHtmlFormFromUiResource(
          resourceFactory, formService, htmlFormEntryService, htmlform);
    }
  }
}
