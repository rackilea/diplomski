- (void) prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    if ([segue.identifier isEqualToString:@"textView"])
    {
        //---Pass text to view
        CGRect visibleRect;
        visibleRect.origin = scrollView.contentOffset;
        visibleRect.size = scrollView.bounds.size;

        int number;

        if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPad) {
            number = visibleRect.origin.x / 768;
        }
        else {
            number = visibleRect.origin.x / 320;
        }

        TextViewController *textViewController = segue.destinationViewController;
        AppDelegate *appDelegate = [[UIApplication sharedApplication] delegate];
        textViewController.text = [appDelegate.textArray objectAtIndex:number];
    }
}