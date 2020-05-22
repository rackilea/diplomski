Elements row = doc.select("td[class=css-sched-table-title], td[class=css-sched-waypoints], td[class=css-sched-times]");
        System.out.println("::Total Count::" + row.size());

        Iterator<Element> iterator = row.listIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            String id = element.attr("id");
            String classes = element.attr("class");
            String value = element.text();
            System.out.println("Id : " + id + ", classes : " + classes
                    + ", value : " + value);
        }