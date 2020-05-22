...
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;
import com.jaredrummler.android.processes.models.Stat;
import com.jaredrummler.android.processes.models.Statm;

class YourClass extends Activity {
    List<RunningApplication> runningApplicationList = new ArrayList<>();

    ...
    public void getRunningApps() {
        List<AndroidAppProcess> processes = AndroidProcesses.getRunningAppProcesses();
        PackageManager pm = getPackageManager();
        for (AndroidAppProcess pro : processes) {
           try {
                String proccessname = pro.name;
                Stat stat = pro.stat();
                int pid = stat.getPid();
                int parentProccessId = stat.ppid();
                long startTime = stat.stime();
                int policy = stat.policy();
                char state = stat.state();

                Statm statm = pro.statm();
                long totalSizeofProccess = statm.getSize();
                long residentSetSize = statm.getResidentSetSize();

                PackageInfo packageInfo = pro.getPackageInfo(basecontext, 0);

                //get the app name
                String appName = packageInfo.applicationInfo.loadLabel(pm).toString();
                //Get the app icon
                Drawable appIcon = packageInfo.applicationInfo.loadIcon(pm);
                //Add it to your list of running app
                RunningApplication ra = new RunningApplication(appName,startTime,pid,appIcon);
                runningApplicationList.add(ra);
           } catch (Exception ex) {
                Log.e("APPNAME.CONTEXT",e.getMessage());
           }
        }
    }

}
...