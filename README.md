# Octopus Monitoring
Android survey app for collating fisheries data. 

See [Marine Managment Pays](https://blueventures.org/marine-management-pays/).

## Background

### Android Client
Blue Ventures current Octopus Monitoring solution is an [Open Data Kit](https://opendatakit.org/) form used with the [ODK Collect](https://play.google.com/store/apps/details?id=org.odk.collect.android) application.

### Upload/Database
The collected data is uploaded to an ODK instance running on Google App Engine. Once uploaded it can be read by any suitable system for generating reports. 

### Issues
* ODK Collect usability is extremey poor
* Issues with existing form, eg. if you select **all** for 'How much of the total catch was sold' the user is still presented on the next screen with the question 'What did/will you do with the rest?'

## Aims
* Create a custom Android app with improved UI so data collection is easier to carry out in the field.
* Evaluate the suitability of ODK, and any alternatives for the backend.

## Solution

Develop an Android app to replace the ODK Collect form, maintain a strict separation of concerns between the form and the upload so it can easily be swapped out (proxy code to upload to ODK instance, upload to custom web service populating a DB, Firebase).


