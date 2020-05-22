String folderSearchName = "Archived";

FolderView fvFolderView = new FolderView(1);
fvFolderView.Traversal = FolderTraversal.Shallow;

SearchFilter fsFolderSearch = new SearchFilter.IsEqualTo(FolderSchema.DisplayName, folderSearchName);

FolderId SearchRoot = new FolderId(WellKnownFolderName.MsgFolderRoot, "user@domain.com");

FindFoldersResults folderSearchResults = service.FindFolders(SearchRoot, fsFolderSearch, fvFolderView);
if (folderSearchResults.Folders.Count == 1) 
{
    Console.WriteLine(folderSearchResults.Folders[0].DisplayName);
}