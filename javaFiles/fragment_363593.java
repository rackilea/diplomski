read ANT_HOME; export ANT_HOME
read buildXml1; read buildXml2
echo "Building"
ant build -buildfile $buildXml1  #You now have ant command available

antReturnCode=$?

echo "ANT: Return code is: \""$antReturnCode"\""

if [ $antReturnCode -ne 0 ];then

    echo "BUILD FAILED"
    exit 1;
else

    echo "BUILD SUCCESSFUL"
fi