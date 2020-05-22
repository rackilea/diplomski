private List<WorkItemViewModel> GetWorkItemTree(string query)
{
    var treeQuery = new Query(_workItemStore, query);
    var links = treeQuery.RunLinkQuery();

    var workItemIds = links.Select(l => l.TargetId).ToArray();

    query = "SELECT * FROM WorkItems";
    var flatQuery = new Query(_workItemStore, query, workItemIds);
    var workItemCollection = flatQuery.RunQuery();

    var workItemList = new List<WorkItemViewModel>();

    for (int i = 0; i < workItemCollection.Count; i++)
    {
        var workItem = workItemCollection[i];

        if (workItem.Type.Name == "Requirement")
        {                   
            var model = new WorkItemViewModel()
            {
                Id = workItem.Id,
                RequestNo = workItem.Fields["MyCompany.RequestNumber"].Value.ToString(),
                Title = workItem.Title,
                WorkItemType = workItem.Fields["MyCompany.WorkItemType"].Value.ToString(),
                Priority = workItem.Fields["MyCompany.Priority"].Value.ToString()
            };

            workItemList.Add(model);
        }
        else
        {
            switch (workItem.Type.Name)
            {
                case "Task":
                    var task = new TFSTask()
                    {
                        Name = workItem.Title,
                        Activity = workItem.Fields["MyCompany.Activity"].Value.ToString(),
                        Start = (DateTime?)workItem.Fields["MyCompany.ActivityStart"].Value,
                        Due = (DateTime?)workItem.Fields["MyCompany.ActivityFinish"].Value,
                        Status = workItem.State
                    };

                    workItemList.Last().Tasks.Add(task);
                    break;
                case "Issue":
                    var issue = new TFSIssue()
                    {
                        Name = workItem.Title,
                        Created = workItem.CreatedDate,
                        Due = (DateTime?)workItem.Fields["MyCompany.ActivityDue"].Value,
                        Status = workItem.State
                    };
                    workItemList.Last().Issues.Add(issue);
                    break;
                default:
                    break;
            }
        }
    }

    return workItemList;
}