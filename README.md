# Octopus Monitoring
Android survey app for collating fisheries data. 

* [Marine Managment Pays](https://blueventures.org/marine-management-pays/)
* [Rebuilding Fisheries](https://blueventures.org/conservation/rebuilding-fisheries/)

## Background

### Android Client
Blue Ventures current Octopus Monitoring solution is an [Open Data Kit](https://opendatakit.org/) form used with the [ODK Collect](https://play.google.com/store/apps/details?id=org.odk.collect.android) application.

### Upload/Database
The collected data is uploaded to an ODK instance running on Google App Engine. Once uploaded it can be read by any suitable system for generating reports. 

### Issues
* ODK Collect usability is extremey poor
* Manual entry of today's date
* Validation issues, eg. possible to select later start time than end time.
* Logical issues with existing form, eg. 
  * if you select **all** for 'How much of the total catch was sold' the user is still presented on the next screen with the question 'What did/will you do with the rest?'
  * Select **Gleaning** for method, next screen asks: 'What fishing equipment did they use (gleaning)?' with answers 'Hook and line, Spear, Other' - are these answers relevant for gleaning?
* Fields aren't cached and need to be re-entered/selected every time, some could be preselected but still editable:
  * Name of village
  * Date collector name
  * Name, age, sex of main fisher
  * Fishing site and zonation name/type
  * Fishing method (Free-diving, Gleaning, Snorkelling) 
* Repetion of octopus weight, requested on two screens
* Local currency required for 'Price per kg paid', would be better to have dropdown of currencies and cache selection. Also are transactions always in kg?

## Aims
* Create a custom Android app with improved UI so data collection is easier to carry out in the field.
* Evaluate the suitability of ODK, and any alternatives for the backend.

## Solution

Develop an Android app to replace the ODK Collect form, maintain a strict separation of concerns between the form and the upload so it can easily be swapped out (proxy code to upload to ODK instance, upload to custom web service populating a DB, Firebase).

App should include local store to queue entries that can be uploaded at a later time so the app can be used in the field without cell/wifi access.


