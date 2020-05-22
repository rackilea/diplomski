import com.install4j.runtime.beans.actions.misc.RunExecutableAction;

RunExecutableAction action = new RunExecutableAction();
action.setExecutable(...);
action.setArguments(...);

action.execute(context);