String script = "import {x} from 'lib'";

// these two support "import"
Source source1 =  Source.newBuilder("js", script, "script.mjs").build();
Source source2 =  Source.newBuilder("js", script, "script").mimeType("application/javascript+module").build();

// this one doesn't
//Source source3 =  Source.newBuilder("js", script, "script").build();