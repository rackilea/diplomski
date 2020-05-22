function init()
  %// Initialize the figure with a listener:
  h = figure('WindowButtonMotionFcn',@windowMotion,'Pos',[400,400,200,200]);
  %// Add a "static" text label:
  col = get(h,'color');
  lbl = uicontrol('Style','text', 'Pos',[10,160,120,20], ...
                  'Background',col, 'HorizontalAlignment','left');
  drawnow;
  setptr(gcf, 'fleur'); %// Optional, set default pointer.

function windowMotion(varargin)
    cursor_pos = get(h,'CurrentPoint');
    set(lbl,'String',sprintf('Mouse position: %d, %d',cursor_pos));
    drawnow;

    pos = get(lbl,'position'); %// This doesn't need to happen every time, 
                               %// it's here for the sake of demonstration.
    if (cursor_pos(1)>pos(1) && cursor_pos(1)<pos(1)+pos(3)) && ...
       (cursor_pos(2)>pos(2) && cursor_pos(2)<pos(2)+pos(4)) 
       setptr(gcf, 'hand'); %// Change to this cursor if pointer is inside
                            %// the element.
    else
       setptr(gcf, 'fleur'); %//otherwise (re)change to default
    end

  end

end