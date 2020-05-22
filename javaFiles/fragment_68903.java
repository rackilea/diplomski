public class JobsDataMapper extends Mapper<LongWritable, Text, Text, Text> {
        private Text keytext = new Text();
        private Text valuetext = new Text();
        private String jobT = new String();
        private String jobName= new String();

         @Override
        public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {



 String line = value.toString();

 Document doc = Jsoup.parse(line);
 Elements desc = doc.select("head title, meta[name=twitter:description]");

 for (Element jobhtml : desc){
 Elements title = jobhtml.select("title");


 String jobTT = title.text();
 jobT =jobTT ;

 if (jobT.length()> 0){

 jobName=jobTT;
 }

 Elements meta = jobhtml.select("meta[name=twitter:description]");
 String jobsDetail ="";

 String content = meta.attr("content");

 String content1 = content.replaceAll("\\p{Punct}+", " ");
 jobsDetail = content1.toLowerCase();
 jobsDetail = content1.replaceAll(" a| able | about | across | after | all | almost | also | am | among | an | and | any | are | as | at | be| because | been | but | by | can | cannot | could | dear | did | do | does | either | else | ever | every | for | from | get | got | had | has | have | he | her | hers | him | his | how | however | i | if | in | into | is | it | its | just | least | let | like | likely | may | me | might | most | must | my | neither | no | nor | not | nbsp | of | off | often | on | only | or | other | our | own | rather | said | say | says | she | should | since | so | some | than | that | the | their | them | then | there | these | they | this | tis | to | too | twas | us | wants | was | we | were | what | when | where | which | while | who | whom | why | will | with | would | yet | you | your "," ");




     if (jobsDetail.length()>0) {

String MN_Job = (jobName+ "\t" + jobsDetail);

keytext.set(MN_Job) ;
valuetext.set("JobInIT");
context.write( keytext, valuetext );

 }

 }

 }

 }