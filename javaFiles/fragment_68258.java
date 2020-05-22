case WM_SETCURSOR:
    // If you omit test below, you will change cursor also for scrollbars, frames, etc.
    if ( LOWORD( lparam ) == HTCLIENT )
        SetCursor( cursor_handle );
    else
        // This will also handle cursor for scrollbars and frames.
        return DefWindowProc( hwnd, msg, wparam, lparam );
    return TRUE;