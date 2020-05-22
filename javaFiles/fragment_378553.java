List<Option> options2 = configuration.getDatacenters();
        for (Option option : options2) {   

            Hardware hardware = option.getTemplate();
            String dcName = hardware.getDatacenter().getName();

            System.out.println("dcName : " + dcName );
        }


        List<Option> options3 = configuration.getProcessors();
        for (Option option : options3) {  
            System.out.println("processors");
            System.out.println("item prices");
            System.out.println("hourly recurring fee" + option.getItemPrice().getHourlyRecurringFee());
            System.out.println("item");
            System.out.println("desciption" + option.getItemPrice().getItem().getDescription());
            Hardware hardware = option.getTemplate();
            System.out.println("Template");
            System.out.println("processorCoreAmount : " + hardware.getProcessorCoreAmount() );
            System.out.println("memoryCapacity : " + hardware.getMemoryCapacity() );
        }

    }