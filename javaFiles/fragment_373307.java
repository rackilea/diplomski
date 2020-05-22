<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

class ThreadLoad implements Runnable {
    public void run() {
        long result = 0;
        // increase the amount of loops until sufficient load
        for (long dummy = 0; dummy < 100000000; dummy++) {
            if (dummy % 2 == 0)
                result += dummy;
            else
                result -= dummy;
        }
    }
}

int cpus = Runtime.getRuntime().availableProcessors();
Thread[] threads = new Thread[cpus];

for (int i = 0; i < cpus; i++) {
    threads[i] = new Thread(new ThreadLoad());
    threads[i].start();
}

for (int i = 0; i < cpus; i++) {
    threads[i].join();
}

response.getWriter().println("Done");

%>
</body>
</html>