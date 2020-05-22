windows_package node['name']['JDK1.7']  do
    source                  node['source']['JDK1.7']
    action                  :install
    installer_type          :custom
    options                 "/v\"/qn INSTALLDIR=\\\"#{node['path']['JDK1.7'].gsub('/','\\')}\\\"\""
end