@Override
    protected void onDraw(Canvas canvas){
        //Get points for bounding view
        //Pad = space between polygons
        //leftX = Left bound of parent view
        //rightX = Right bound of parent view
        //topY = Top bound of parent view
        //bottomY = Bottom bound of parent view
        //width = Width of a single polygon before transform
        //peak = How far a polygon will reach into the space of another polygon after transform (1/3 polygon width)
        //tip = peak with padding taken into account
//        var context = UIGraphicsGetCurrentContext()
//        var pad:CGFloat = (CGFloat)(Numbers.APPLICATIONPADDING)
//        var leftX:CGFloat = (CGFloat)(self.bounds.origin.x)
//        var rightX:CGFloat = (CGFloat)(self.bounds.size.width)
//        var topY:CGFloat = (CGFloat)(self.bounds.origin.y)
//        var bottomY:CGFloat = (CGFloat)(self.bounds.size.height)
//        var width:CGFloat = (CGFloat)(self.bounds.width) / (CGFloat)(applications.count)
//        var peak:CGFloat = width/3.0
//        var tip:CGFloat = peak - pad

//
        //Draw all applications
//        var appNum:CGFloat = 1.0
//        var appCount:CGFloat = (CGFloat)(applications.count)
//        var endTopX:CGFloat = 0.0
//        var endBottomX:CGFloat = 0.0
//        var temp:CGFloat!
//        var textRightX:CGFloat = 0.0
//        var textLeftX:CGFloat = 0.0
//        var label:UILabel!
        if(applications.length > 0){
            //float density = getContext().getResources().getDisplayMetrics().density;
            int appNum = 1;
            int appCount = applications.length;
            float endTopX = 0;
            float endBottomX = 0;
            float textRightX = 0;
            float textLeftX = 0;
            float pad = 10;
            float leftX = 0;
            float rightX = viewWidth;
            float topY = 0;
            float bottomY = viewHeight;
            float width = viewWidth / applications.length;
            float peak = viewWidth / 3;
            float tip = peak - pad;
            String colorS;
    //        for app in applications{
            for(ApplicationWithNotes app : applications){
                path.reset();
    //            if(app.color != nil){
    //                CGContextSetFillColorWithColor(context, app.color!.CGColor)
    //            }
    //            else{
    //                CGContextSetFillColorWithColor(context, Colors.PARTCOLORDEFAULT.CGColor)
    //            }

                //Each polygon will breach into the space of the next and the previous after transform by the tip with a given padding
                //Each text field will stretch across the middle of each polygon with a small padding (3) to prevent overreaching
    //            if(appNum == 1 && applications.count == 1){
    //                CGContextMoveToPoint(context, leftX, topY)
    //                CGContextAddLineToPoint(context, width, topY)
    //                CGContextAddLineToPoint(context, width, bottomY)
    //                CGContextAddLineToPoint(context, leftX, bottomY)
    //            }
                if(appNum == 1 && applications.length == 1){
                    path.moveTo(leftX, topY);
                    path.lineTo(width, topY);
                    path.lineTo(width, bottomY);
                    path.lineTo(leftX, bottomY);
                    path.close();

                    borderPath.moveTo(leftX, topY);
                    borderPath.lineTo(width, topY);
                    borderPath.lineTo(width, bottomY);
                    borderPath.lineTo(leftX, bottomY);
                    borderPath.close();

                    textLeftX = 0;
                    textRightX = viewWidth;
                }
    //            if(appNum == 1){
    //                CGContextMoveToPoint(context, leftX, topY)
    //                CGContextAddLineToPoint(context, width + tip, topY)
    //                CGContextAddLineToPoint(context, width - peak, bottomY)
    //                CGContextAddLineToPoint(context, leftX, bottomY)
    //                textLeftX = leftX + (leftX - leftX) / 2 + 3
    //                textRightX = (width - peak) + ((width + tip) - (width - peak)) / 2.0 - 10
    //                endTopX = width + tip
    //                endBottomX = width - peak
    //            }
                else if(appNum == 1){
                    path.moveTo(leftX, topY);
                    path.lineTo(width + tip, topY);
                    path.lineTo(width - peak, bottomY);
                    path.lineTo(leftX, bottomY);
                    path.close();

                    borderPath.moveTo(leftX, topY);
                    borderPath.lineTo(width + tip, topY);
                    borderPath.lineTo(width - peak, bottomY);
                    borderPath.lineTo(leftX, bottomY);
                    borderPath.close();

                    textLeftX = leftX + (leftX - leftX) / 2 + 3;
                    textRightX = (width - peak) + ((width + tip) - (width - peak)) / 2 - 10;
                    endTopX = width + tip;
                    endBottomX = width - peak;
                }
    //            else if(appNum == appCount){
    //                CGContextMoveToPoint(context, endTopX + pad, topY)
    //                CGContextAddLineToPoint(context, rightX, topY)
    //                CGContextAddLineToPoint(context, rightX, bottomY)
    //                CGContextAddLineToPoint(context, endBottomX + pad, bottomY)
    //                textLeftX = (endBottomX + pad) + ((endTopX + pad) - (endBottomX + pad)) / 2.0 + 10
    //                textRightX = rightX + (rightX - rightX) / 2.0 - 10
    //                endTopX = width
    //                endBottomX = width
    //            }
                else if(appNum == appCount){
                    path.moveTo(endTopX + pad, topY);
                    path.lineTo(rightX, topY);
                    path.lineTo(rightX, bottomY);
                    path.lineTo(endBottomX + pad, bottomY);
                    path.close();

                    borderPath.moveTo(endTopX + pad, topY);
                    borderPath.lineTo(rightX, topY);
                    borderPath.lineTo(rightX, bottomY);
                    borderPath.lineTo(endBottomX + pad, bottomY);
                    borderPath.close();

                    textLeftX = (endBottomX + pad) + ((endTopX + pad) - (endBottomX + pad)) / 2 + 10;
                    textRightX = rightX + (rightX - rightX) / 2 - 10;
                    endTopX = width;
                    endBottomX = width;
                }
    //            else{
    //                CGContextMoveToPoint(context, endTopX + pad, topY)
    //                CGContextAddLineToPoint(context, width * appNum + tip, topY)
    //                CGContextAddLineToPoint(context, width * appNum - peak, bottomY)
    //                CGContextAddLineToPoint(context, endBottomX + pad, bottomY)
    //                textLeftX = (endBottomX + pad) + ((endTopX + pad) - (endBottomX + pad)) / 2 + 10
    //                textRightX = (width * appNum - peak) + ((width * appNum + tip) - (width * appNum - peak)) / 2 - 3
    //                endTopX = width * appNum + tip
    //                endBottomX = width * appNum - peak
    //            }
                else{
                    path.moveTo(endTopX + pad, topY);
                    path.lineTo(width * appNum + tip, topY);
                    path.lineTo(width * appNum - peak, bottomY);
                    path.lineTo(endBottomX + pad, bottomY);
                    path.close();

                    borderPath.moveTo(endTopX + pad, topY);
                    borderPath.lineTo(width * appNum + tip, topY);
                    borderPath.lineTo(width * appNum - peak, bottomY);
                    borderPath.lineTo(endBottomX + pad, bottomY);
                    borderPath.close();

                    textLeftX = (endBottomX + pad) + ((endTopX + pad) - (endBottomX + pad)) / 2 + 10;
                    textRightX = (width * appNum - peak) + ((width * appNum + tip) - (width * appNum - peak)) / 2 - 3;
                    endTopX = width * appNum + tip;
                    endBottomX = width * appNum - peak;
                }
    //            CGContextFillPath(context)
                paint.setStyle(Paint.Style.FILL);
                if(app.application.colorCode != null){
                    colorS = "#" + app.application.colorCode;
                    paint.setColor(Color.parseColor(colorS));
                }
                else{
                    paint.setColor(getResources().getColor(R.color.default_application));
                }
                canvas.drawPath(path, paint);

//              borderPaint.setStyle(Paint.Style.STROKE);
//              borderPaint.setColor(getResources().getColor(R.color.application_border));
//              canvas.drawPath(borderPath, borderPaint);
    //
                //Add text label
    //            label = UILabel(frame: CGRectMake(textLeftX, topY, (textRightX-textLeftX), bottomY))
    //            label.textAlignment = NSTextAlignment.Center
    //            label.text = app.baseSeries
    //            label.numberOfLines = 1
    //            label.adjustsFontSizeToFitWidth = true
    //            label.font = UIFont(name:"OpenSans-SemiBold", size:30)

    //
    //            self.addSubview(label)
    //            appBounds.append(label.frame)

    //
    //            appNum++
                textViews.add(app.application.baseSeries);
                textViewsDimens.add(new float[]{textLeftX, textRightX});
                appNum++;
    //        }
            }
    //        self.layer.borderColor = UIColor.lightGrayColor().CGColor
    //        self.layer.borderWidth = 1.0
    //      
            if(!addedTextViews){
                createTextViews();
            }
        }
    }

    private void createTextViews(){
        AutoResizeTextView label;
        LayoutParams layout;
        for(int i = 0; i < textViews.size(); i++){
            label = new AutoResizeTextView(getContext());
            label.setText(textViews.get(i));
            label.setTextAppearance(getContext(), R.style.ApplicationText);
            layout = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layout.topMargin = 0;
            layout.height = viewHeight;
            layout.leftMargin = (int) textViewsDimens.get(i)[0];
            layout.width = (int) textViewsDimens.get(i)[1] - (int) textViewsDimens.get(i)[0];
            label.setLayoutParams(layout);
            this.addView(label);
            label.setGravity(Gravity.CENTER);
        }
        addedTextViews = true;
    }