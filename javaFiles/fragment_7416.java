Request ID: 9f425b1c
Repo Path ID: libs-release:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
Method Name: GET
Time: 2019-09-05T15:41:07.877Z
Steps: 
2019-09-05T15:41:07.877Z Received request
2019-09-05T15:41:07.877Z Executing any BeforeDownloadRequest user plugins that may exist
2019-09-05T15:41:07.877Z Retrieving info from virtual repository 'libs-release' type Maven
2019-09-05T15:41:07.877Z Consulting the virtual repo download strategy
2019-09-05T15:41:07.877Z Trying to retrieve resource info from the local storage
2019-09-05T15:41:07.879Z Unable to find resource in libs-release:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.879Z Intercepting cached virtual resource with 'MavenMetadataInterceptor'
2019-09-05T15:41:07.879Z Intercepting cached virtual resource with 'PomInterceptor'
2019-09-05T15:41:07.879Z Searching for info in aggregated repositories
2019-09-05T15:41:07.879Z Preparing list of aggregated repositories to search in
2019-09-05T15:41:07.879Z Appending the nested virtual repository 'libs-release'
2019-09-05T15:41:07.879Z Appending collective local repositories
2019-09-05T15:41:07.879Z Appending collective local cache repositories
2019-09-05T15:41:07.879Z Appending collective remote repositories
2019-09-05T15:41:07.879Z Appending collective remote repositories
2019-09-05T15:41:07.879Z Appending collective remote repositories
2019-09-05T15:41:07.879Z Appending collective remote repositories
2019-09-05T15:41:07.879Z Appending collective remote repositories
2019-09-05T15:41:07.879Z Intercepting info request with 'MavenMetadataInterceptor'
2019-09-05T15:41:07.879Z Intercepting info request with 'PomInterceptor'
2019-09-05T15:41:07.879Z Processing request as a release resource
2019-09-05T15:41:07.879Z Searching for the resource within libs-release-local
2019-09-05T15:41:07.879Z Unable to find resource in libs-release-local:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.879Z Searching for the resource within central-cache
2019-09-05T15:41:07.880Z Unable to find resource in central-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.880Z Searching for the resource within repository.spring.milestone-cache
2019-09-05T15:41:07.881Z Unable to find resource in repository.spring.milestone-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.881Z Searching for the resource within jcenter-cache
2019-09-05T15:41:07.881Z Unable to find resource in jcenter-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.881Z Searching for the resource within jboss-cache
2019-09-05T15:41:07.882Z Unable to find resource in jboss-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.882Z Searching for the resource within rabbit-milestone-cache
2019-09-05T15:41:07.882Z Unable to find resource in rabbit-milestone-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.882Z Searching for the resource within central
2019-09-05T15:41:07.883Z Unable to find resource in central-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.883Z Executing any AltRemotePath user plugins that may exist
2019-09-05T15:41:07.883Z Appending matrix params to remote request URL
2019-09-05T15:41:07.883Z Using remote request URL - https://repo.maven.apache.org/maven2/org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.883Z Executing HEAD request to https://repo.maven.apache.org/maven2/org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.906Z Found remote resource with last modified time - Wed Jun 28 09:19:33 UTC 2006
2019-09-05T15:41:07.906Z Found remote resource with ETag - "9bef270e593bf6dcc37a4e3014b5f94a"
2019-09-05T15:41:07.906Z Found remote resource with content length - 13452
2019-09-05T15:41:07.913Z Found remote resource with checksums - [ChecksumInfo{type=SHA-1, original='5274e75bb357203fbc61c529b7bfc174357dbff8', actual='null'}, ChecksumInfo{type=MD5, original='9bef270e593bf6dcc37a4e3014b5f94a', actual='null'}]
2019-09-05T15:41:07.913Z Returning found remote resource info
2019-09-05T15:41:07.913Z Resource was found in central
2019-09-05T15:41:07.913Z Resource is an exact match - returning
2019-09-05T15:41:07.913Z Returning resource as found in the aggregated repositories
2019-09-05T15:41:07.913Z Intercepting found resource with 'MavenMetadataInterceptor'
2019-09-05T15:41:07.913Z Intercepting found resource with 'PomInterceptor'
2019-09-05T15:41:07.913Z The requested resource isn't pre-resolved
2019-09-05T15:41:07.913Z Target repository isn't virtual - verifying that downloading is allowed
2019-09-05T15:41:07.913Z Creating a resource handle from 'central'
2019-09-05T15:41:07.913Z Target repository is configured to retain artifacts locally - resource will be stored and the streamed to the user
2019-09-05T15:41:07.913Z Remote repository is online
2019-09-05T15:41:07.914Z Unable to find resource in central-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.914Z Found expired cached resource but remote is newer = false. Cached resource: 0, Remote resource: 1151486373000
2019-09-05T15:41:07.914Z Force expiration on the cached resource = false
2019-09-05T15:41:07.914Z Resource isn't cached and isn't expired = true
2019-09-05T15:41:07.914Z Asserting valid deployment path
2019-09-05T15:41:07.915Z Creating a resource handle from 'central-cache:org/apache/geronimo/specs/specs/1.1/specs-1.1.pom'
2019-09-05T15:41:07.915Z Unable to find the resource - throwing exception
2019-09-05T15:41:07.916Z Unable to find cached resource stream handle, continuing with actual remote download.
2019-09-05T15:41:07.916Z Found no cached resource - starting download
2019-09-05T15:41:07.916Z Downloading and saving
2019-09-05T15:41:07.916Z Eager source JAR fetching enabled = true
2019-09-05T15:41:07.916Z Eager JAR fetching enabled = false
2019-09-05T15:41:07.916Z Valid Maven artifact info = true
2019-09-05T15:41:07.916Z Artifact has classifier = false
2019-09-05T15:41:07.916Z Eager JAR and source JAR fetching is not attempted
2019-09-05T15:41:07.916Z Remote property synchronization enabled = false
2019-09-05T15:41:07.916Z Received remote checksums headers - [ChecksumInfo{type=SHA-1, original='5274e75bb357203fbc61c529b7bfc174357dbff8', actual='null'}, ChecksumInfo{type=MD5, original='9bef270e593bf6dcc37a4e3014b5f94a', actual='null'}]
2019-09-05T15:41:07.916Z Executing any AltRemoteContent user plugins that may exist
2019-09-05T15:41:07.916Z Received no alternative content handle from a user plugin
2019-09-05T15:41:07.916Z Received no alternative content, received remote checksums headers and searching for existing resources on download is enabled
2019-09-05T15:41:07.916Z Searching for existing resource with SHA-1 '5274e75bb357203fbc61c529b7bfc174357dbff8'
2019-09-05T15:41:07.916Z Received no alternative content or existing resource - downloading resource
2019-09-05T15:41:07.916Z Appending matrix params to remote request URL
2019-09-05T15:41:07.916Z Using remote request URL - https://repo.maven.apache.org/maven2/org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.916Z Executing any BeforeRemoteDownload user plugins that may exist
2019-09-05T15:41:07.916Z Executing GET request to https://repo.maven.apache.org/maven2/org/apache/geronimo/specs/specs/1.1/specs-1.1.pom
2019-09-05T15:41:07.919Z Downloading content
2019-09-05T15:41:07.919Z Saving resource to central-cache
2019-09-05T15:41:07.975Z Failed to download: Failed to read POM for 'org/apache/geronimo/specs/specs/1.1/specs-1.1.pom': expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</developers>\n    `\n    <p... @91:7) .
2019-09-05T15:41:07.975Z Executing any AfterRemoteDownload user plugins that may exist
2019-09-05T15:41:07.975Z Executed all AfterRemoteDownload user plugins
2019-09-05T15:41:07.975Z Error occurred while downloading artifact: Failed to read POM for 'org/apache/geronimo/specs/specs/1.1/specs-1.1.pom': expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</developers>\n    `\n    <p... @91:7) .
2019-09-05T15:41:07.976Z Requested resource is found = false
2019-09-05T15:41:07.976Z Request is HEAD = false
2019-09-05T15:41:07.976Z Request is for a checksum = false
2019-09-05T15:41:07.976Z Target repository is not remote or doesn't store locally = false
2019-09-05T15:41:07.976Z Requested resource was not modified = false
2019-09-05T15:41:07.976Z Responding with unfound resource
2019-09-05T15:41:07.976Z Setting default response status to '404' reason to 'Resource not found'
2019-09-05T15:41:07.976Z Response is an instance of UnfoundRepoResourceReason
2019-09-05T15:41:07.976Z Configured to hide un-authorized resources = false
2019-09-05T15:41:07.976Z Original response status is auth related = false
2019-09-05T15:41:07.976Z Using original response status of '404' and message 'Failed to transform pom file: Failed to read POM for 'org/apache/geronimo/specs/specs/1.1/specs-1.1.pom': expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</developers>\n    `\n    <p... @91:7) .'
2019-09-05T15:41:07.976Z Sending error with status 404 and message 'Failed to transform pom file: Failed to read POM for 'org/apache/geronimo/specs/specs/1.1/specs-1.1.pom': expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</developers>\n    `\n    <p... @91:7) .'
2019-09-05T15:41:07.976Z Executing any AfterDownloadErrorAction user plugins that may exist
2019-09-05T15:41:07.976Z Response code wasn't modified by the user plugins
2019-09-05T15:41:07.976Z Sending response with the status '404' and the message 'Failed to transform pom file: Failed to read POM for 'org/apache/geronimo/specs/specs/1.1/specs-1.1.pom': expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</developers>\n    `\n    <p... @91:7) .'