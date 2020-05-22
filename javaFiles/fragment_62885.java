Bundle optsBundle = null;
            ActivityOptions opts = null;
            if (Utilities.ATLEAST_MARSHMALLOW) {
                int left = 0, top = 0;
                int width = v.getMeasuredWidth(), height = v.getMeasuredHeight();
//                    if (v instanceof TextView) {
//                        // Launch from center of icon, not entire view
//                        Drawable icon = Workspace.getTextViewIcon((TextView) v);
//                        if (icon != null) {
//                            Rect bounds = icon.getBounds();
//                            left = (width - bounds.width()) / 2;
//                            top = v.getPaddingTop();
//                            width = bounds.width();
//                            height = bounds.height();
//                        }
//                    }
                opts = ActivityOptions.makeClipRevealAnimation(v, left, top, width, height);
            } else if (!Utilities.ATLEAST_LOLLIPOP) {
                // Below L, we use a scale up animation
                opts = ActivityOptions.makeScaleUpAnimation(v, 0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            } else if (Utilities.ATLEAST_LOLLIPOP_MR1) {
                // On L devices, we use the device default slide-up transition.
                // On L MR1 devices, we use a custom version of the slide-up transition which
                // doesn't have the delay present in the device default.
                opts = ActivityOptions.makeCustomAnimation(context, R.anim.task_open_enter, R.anim.no_anim);
            }
            optsBundle = opts != null ? opts.toBundle() : null;

            context.startActivity(intent, optsBundle);