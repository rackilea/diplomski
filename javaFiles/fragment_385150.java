<ul>
        #foreach ($row in $db_data)
            <li>
                <div>
                    <a href="/projects/${row.id}" style="font-size:16px"> ${row.value} </a>
                </div>
            </li>
        #end
    </ul>