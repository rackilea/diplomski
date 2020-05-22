/^                 # match beginning
    (
        \d{1,3}    # one address segment
        \.         # separation dot
        \d{1,3})   # second address segment
    \.             # separation dot
    \d{1,3}        # address segment to be replaced
    \.             # separation dot
    (\d{1,3})      # last address segment
$/x                # match end, ignore comments