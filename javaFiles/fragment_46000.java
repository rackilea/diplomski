$.each($contentMenu.children(), function (index) {
        if (index === 0) {} else {
            $(this).removeClass('profilebuttons').appendTo($profileButtons.find('.profileButtonsCollection'));
            $(this).clone(true,true).removeClass('profilebuttons').appendTo($profileButtons.find('#websiteUrls').find('.menu'));
        }
    });