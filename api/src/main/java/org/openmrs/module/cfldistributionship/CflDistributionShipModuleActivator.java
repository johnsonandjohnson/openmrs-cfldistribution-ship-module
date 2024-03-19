package org.openmrs.module.cfldistributionship;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.ModuleException;
import org.openmrs.module.cfldistributionship.metadata.AppConfigMetadata;
import org.openmrs.module.cfldistributionship.metadata.HtmlFormsMetadata;
import org.openmrs.module.emrapi.utils.MetadataUtil;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;

import static org.openmrs.api.context.Context.getRegisteredComponent;

public class CflDistributionShipModuleActivator extends BaseModuleActivator {
  private Log log = LogFactory.getLog(this.getClass());

  @Override
  public void started() {
    log.info("Started Cfl Distribution SHIP Module");
    try {
      // The ZIP packages
      MetadataUtil.setupStandardMetadata(getClass().getClassLoader());
      loadMetadataJavaBundles();
    } catch (Exception e) {
      throw new ModuleException("Failed to activate cfldistribution-ship module!", e);
    }
  }

  @Override
  public void stopped() {
    log.info("Shutting down Cfl Distribution SHIP Module");
  }

  private void loadMetadataJavaBundles() {
    final MetadataDeployService service =
        getRegisteredComponent("metadataDeployService", MetadataDeployService.class);

    service.installBundle(
        getRegisteredComponent("cflship-HtmlFormsMetadata", HtmlFormsMetadata.class));
    service.installBundle(
        getRegisteredComponent("cflship-AppConfigMetadata", AppConfigMetadata.class));
  }
}
