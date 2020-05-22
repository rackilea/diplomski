private DRDesignList pageXofY(DRIPageXofY pageXofY, DefaultStyleType    defaultStyleType) throws DRException {
        TemplateTransform templateTransform = accessor.getTemplateTransform();
        DRIReportStyle pageXofYStyle = pageXofY.getStyle();
        if (pageXofYStyle == null) {
            pageXofYStyle = accessor.getTemplateTransform().getTextStyle();
        }
        DRDesignStyle style = accessor.getStyleTransform().transformStyle(pageXofYStyle, true, defaultStyleType);
        Integer height = templateTransform.getPageXofYHeight(pageXofY, style);
        HorizontalAlignment horizontalAlignment = templateTransform.getPageXofYHorizontalAlignment(pageXofY, style);

        DRStyle newStylePageX = new DRStyle();
        newStylePageX.setParentStyle(pageXofYStyle);
        newStylePageX.getPadding().setRight(0);
        DRPen pen = new DRPen();
        pen.setLineWidth(0f);
        newStylePageX.getBorder().setRightPen(pen);
        DRStyle newStylePageY = new DRStyle();
        newStylePageY.setParentStyle(pageXofYStyle);
        newStylePageY.getPadding().setLeft(0);
        newStylePageY.getBorder().setLeftPen(pen);

        DRTextField<String> pageXField = new DRTextField<String>();
        pageXField.setAnchorNameExpression(pageXofY.getAnchorNameExpression());
        pageXField.setBookmarkLevel(pageXofY.getBookmarkLevel());
        pageXField.setHyperLink((DRHyperLink) pageXofY.getHyperLink());
        pageXField.setPrintWhenExpression(pageXofY.getPrintWhenExpression());
        pageXField.setStyle(newStylePageX);
        pageXField.setHeight(height);
        pageXField.setHeightType(pageXofY.getHeightType());
        pageXField.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        pageXField.setValueExpression(new PageXofYNumberExpression(pageXofY.getFormatExpression(), 0));

        DRTextField<String> pageYField = new DRTextField<String>();
        pageYField.setAnchorNameExpression(pageXofY.getAnchorNameExpression());
        pageYField.setBookmarkLevel(pageXofY.getBookmarkLevel());
        pageYField.setHyperLink((DRHyperLink) pageXofY.getHyperLink());
        pageYField.setPrintWhenExpression(pageXofY.getPrintWhenExpression());
        pageYField.setStyle(newStylePageY);
        pageYField.setHeight(height);
        pageYField.setHeightType(pageXofY.getHeightType());
        pageYField.setHorizontalAlignment(HorizontalAlignment.LEFT);
        pageYField.setValueExpression(new PageXofYNumberExpression(pageXofY.getFormatExpression(), 1));
        DRIGroup pageYEvaluationGroup = accessor.getGroupTransform().getFirstResetPageNumberGroup();
        if (pageYEvaluationGroup == null) {
            pageYField.setEvaluationTime(Evaluation.REPORT);
        }
        else {
            pageYField.setEvaluationTime(Evaluation.GROUP);
            pageYField.setEvaluationGroup((DRGroup) pageYEvaluationGroup);
        }

        int pageXofYWidth = templateTransform.getPageXofYWidth(pageXofY, style);
        switch (horizontalAlignment) {
        case LEFT:
            int pageXWidth = StyleResolver.getFontWidth(style, 4);
            int pageYWidth = pageXofYWidth - pageXWidth;
            if (pageYWidth <= 0) {
                pageYWidth = 10;
            }
            pageXField.setWidth(pageXWidth);
            pageXField.setWidthType(ComponentDimensionType.FIXED);
            pageYField.setWidth(pageYWidth);
            pageYField.setWidthType(pageXofY.getWidthType());
            break;
        case RIGHT:
            pageYWidth = StyleResolver.getFontWidth(style, 6);
            pageXWidth = pageXofYWidth - pageYWidth;
            if (pageXWidth <= 0) {
                pageXWidth = 10;
            }
            pageXField.setWidth(pageXWidth);
            pageXField.setWidthType(pageXofY.getWidthType());
            pageYField.setWidth(pageYWidth);
            pageYField.setWidthType(ComponentDimensionType.FIXED);
            break;
        default:
            pageXField.setWidth(pageXofYWidth / 2);
            pageXField.setWidthType(pageXofY.getWidthType());
            pageYField.setWidth(pageXofYWidth / 2);
            pageYField.setWidthType(pageXofY.getWidthType());
            break;
        }

        DRList listPageXofY = new DRList();
        listPageXofY.addComponent(pageXField);
        listPageXofY.addComponent(pageYField);
        return list(listPageXofY, DefaultStyleType.TEXT, null, null);
    }