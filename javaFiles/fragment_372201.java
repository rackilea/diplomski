$(htmlRootSelector).contents().each(function processNodes(index, element) {
    var classMeta = getMetaByClass(element.className);

    if (!classMeta) {
      $(element).contents().each(processNodes);
      return;
    }

    var pdfObj = {};
    pdfObj.width = classMeta.width || angular.undefined;
    pdfObj.height = classMeta.height || angular.undefined;
    pdfObj.style = classMeta.style || angular.undefined;
    pdfObj.pageBreak = classMeta.pageBreak || angular.undefined;

    switch (classMeta.type) {
    case 'text':
      pdfObj.text = element.innerText;
      pdfDefinition.content.push(pdfObj);
      break;
    case 'table':
      var tableArray = [];
      var headerArray = [];
      var headers = $(element).find('th');
      var rows = $(element).find('tr');
      $.each(headers, function (i, header) {
        headerArray.push({text: header.innerHTML, style: classMeta.style + '-header'});
      });
      tableArray.push(headerArray);

      $.each(rows, function (i, row) {
        var rowArray = [];
        var cells = $(row).find('td');

        if (cells.length) {
          $.each(cells, function (j, cell) {
            rowArray.push(i % 2 === 1 ? {text: cell.innerText, style: classMeta.style + '-odd-row'} : cell.innerText);
          });

          tableArray.push(rowArray);
        }
      });

      pdfObj.table = {
        widths: $.map(headers, function (d, i) {
          return i === 0 ? 80 : '*';
        }),
        body: tableArray
      };
      pdfDefinition.content.push(pdfObj);
      break;
    case 'image':
      html2CanvasCount++;
      htmlToCanvas(element, pdfObj);
      pdfDefinition.content.push(pdfObj);
      break;
    case 'svg':
      svgToCanvas(element, pdfObj);
      pdfDefinition.content.push(pdfObj);
      break;
    default:
      break;
    }

    $(element).contents().each(processNodes);
  });