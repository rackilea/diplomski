integration_layout = Layout.new
integration_layout[:source, :test, :java] = _('src/integration/java')
define "integrate", :layout => integration_layout do
    test.with TEST_CLASSPATH
    test.using :integration
    integration.setup { Rake::Task['my_project:jetty_start'].invoke }
    integration.teardown { Rake::Task['my_project:jetty_stop'].invoke }
end