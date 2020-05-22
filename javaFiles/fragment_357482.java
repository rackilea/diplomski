package ch.itp.absencemanagersync.synchronize;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.modelmapper.AbstractConverter;

import ch.itp.absencemanagersync.util.ConfigApp;
import ch.itp.absencemanagersync.util.ConfigKeys;

public class ModelmapperMemberOfToIsAdminConverter extends AbstractConverter<List<String>, Boolean>{

    private List<String> comparisonList = Arrays.asList(ConfigApp.get(ConfigKeys.AD_DISTINGUISHEDNAME_ADMINS).split(";"));

    protected ModelmapperMemberOfToIsAdminConverter(){  
    }
    @Override
    protected Boolean convert(List<String> source) {
        if (!Collections.disjoint(source, comparisonList)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}