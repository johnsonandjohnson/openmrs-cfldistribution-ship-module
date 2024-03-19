package org.openmrs.module.cfldistributionship.metadata;

import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.metadatadeploy.bundle.VersionedMetadataBundle;

import static java.util.Arrays.asList;

public class AppConfigMetadata extends VersionedMetadataBundle {
  private static final String[] ENABLE_APPS = {
    "cfl.latestobsforconceptlis", "cfl.patientDashboard.improvements", "cfl.relationships"
  };
  private static final String[] DISABLE_APPS = {
    "appointmentschedulingui.homeApp",
    "appointmentschedulingui.requestAppointmentApp",
    "appointmentschedulingui.schedulingAppointmentApp",
    "appointmentschedulingui.tab",
    "attachments.attachments.overallActions.default",
    "cfl.dashboard.diagnoses",
    "cfl.findPerson",
    "cfl.medical.visit.note",
    "cfl.patient.additionalprofile",
    "cfl.patientProgram.list",
    "cfl.patientProgram.widget",
    "cfl.program.enrollment",
    "cfl.registerCaregiver",
    "cfl.registerPatient",
    "cfl.relationships.widget",
    "cflui.findCaregiver",
    "cflui.registerCaregiver",
    "chartsearch.chartSearchLink",
    "coreapps.activeVisits",
    "coreapps.awaitingAdmission",
    "coreapps.conditionlist",
    "coreapps.dataManagementApp",
    "coreapps.diagnoses",
    "coreapps.findPatient",
    "coreapps.latestObsForConceptList",
    "coreapps.mostRecentVitals",
    "coreapps.obsAcrossEncounters",
    "coreapps.obsGraph",
    "coreapps.relationships",
    "coreapps.visitByEncounterType",
    "org.openmrs.module.allergyui.patientDashboard.secondColumnFragments",
    "org.openmrs.module.appointmentschedulingui.firstColumnFragments.patientDashboard.patientAppointments",
    "org.openmrs.module.attachments.patientDashboard.secondColumnFragments.att",
    "org.openmrs.module.coreapps.createRetrospectiveVisit",
    "org.openmrs.module.coreapps.createVisit",
    "org.openmrs.module.coreapps.markPatientDead",
    "org.openmrs.module.coreapps.mergeVisits",
    "org.openmrs.module.coreapps.patientHeader.secondLineFragments.activeVisitStatus",
    "org.openmrs.module.coreapps.patientHeader.secondLineFragments.stickyNote",
    "org.openmrs.module.locationbasedaccess.editLocation",
    "org.openmrs.module.locationbasedaccess.patientHeader.secondLineFragments.patientLocation",
    "org.openmrs.module.registrationapp.editPatientDemographics",
    "patientflags.patientDashboard.secondColumnFragments",
    "referenceapplication.registrationapp.registerPatient",
    "referenceapplication.vitals",
    "registrationapp.basicRegisterPatient"
  };

  private AppFrameworkService appFrameworkService;

  @Override
  public int getVersion() {
    return 1;
  }

  public void setAppFrameworkService(AppFrameworkService appFrameworkService) {
    this.appFrameworkService = appFrameworkService;
  }

  @Override
  protected void installEveryTime() throws Exception {
    // nothing to do
  }

  @Override
  protected void installNewVersion() throws Exception {
    asList(ENABLE_APPS).forEach(appFrameworkService::enableApp);
    asList(DISABLE_APPS).forEach(appFrameworkService::disableApp);
  }
}
