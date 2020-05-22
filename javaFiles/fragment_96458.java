<cfscript>
factory = createObject("java","coldfusion.server.ServiceFactory");
request.sqlexecutive = factory.getDataSourceService();
newPass = request.sqlexecutive.encryptPassword("p455w0rd");
</cfscript>

<cfoutput>Encrypted: #newPass#<br></cfoutput>