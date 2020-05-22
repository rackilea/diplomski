function [] = gcboDemo()
%[  
    % Create figure
    fig = figure('Name', 'Hello', 'units', 'normalized', 'Position', [1/5, 0.5, 1/5, 1/5]);

    % Add check box
    cb =uicontrol('Parent', fig, 'Style', 'Checkbox', 'units', 'normalized', 'Position', [1/5, 4/5, 1/3, 1/5], 'String', 'Use modified gcbo');

    % Add standard matlab button
    matlabBtn = uicontrol('Parent', fig, 'units', 'normalized', 'Position', [1/5, 0.5, 1/5, 1/5], 'String', 'Matlab');
    set(matlabBtn, 'Callback', @(sender, args)onBtnClicked(cb))

    % Add java button
    [javaBtn, jContainer] = javacomponent('javax.swing.JButton', [0 0 1 1], fig); 
    set(jContainer, 'units', 'normalized', 'position', [3/5, 0.5, 1/5, 1/5]);
    set(jContainer, 'Tag', char(java.util.UUID.randomUUID));
    javaBtn.setText('Java');
    set(javaBtn, 'ActionPerformedCallback', @(sender, args)onBtnClicked(cb))
%]
end
function [] = onBtnClicked(cb)
%[
    % Check if using 'gcboex'
    useGcboex = (get(cb, 'Value') ~= 0);

    if (useGcboex)
        [controlOriginatingCallback, figureContainingObjectOriginatingCallback] = gcboex();
    else
        [controlOriginatingCallback, figureContainingObjectOriginatingCallback] = gcbo();
    end

    if (~isempty(figureContainingObjectOriginatingCallback))
        msg = sprintf('Control = `%s` in Figure = `%s`', class(controlOriginatingCallback), get(figureContainingObjectOriginatingCallback, 'Name'));
    else
        msg = sprintf('Control = `%s` in Figure = `???`', class(controlOriginatingCallback));
    end

    b = msgbox(msg, 'modal');
    if (useGcboex)
        moveguiex(b, 'Over', figureContainingObjectOriginatingCallback);
    end
    uiwait(b);
%]
end

%% ----
function [control, fig] = gcboex()
%[
    % Obtain graphical element whose callback is executing
    control = get(0, 'CallbackObject');

    % Case not executing from callback on a graphical element
    if (isempty(control) || ~(ishghandle(control) || ishandle(control)))
        control = [];
        fig = [];
        return;
    end

    % Obtain the figure containing the graphical element
    if (isempty(strfind(class(control), 'javahandle_withcallbacks')))

        fig = ancestor(control, 'figure'); % Do the same as native `gcbo` routine

    else
        try

            % Obtain the containing figure as a java handle
            thisFigure = get(control, 'TopLevelAncestor');
            if (isempty(strfind(class(thisFigure), 'FigureFrameProxy'))), error('Not inside a figure'); end

            % Obtain all figures as matlab handles
            allFigures = findobj(0, 'Type', 'figure');

            % Temporarly modify figure names one by one and check
            % from the java side that this our title that has changed
            %
            % NB: Would be easier to do modify java-side title or ToolTipString
            % and use 'findobj' but when we modify java-side the changes are not
            % reported on matlab side even with forceGuiUpdate, so we do the reverse (which is working) ...
            fig = []; 
            searchedName = char(java.util.UUID.randomUUID);
            for fi = 1:length(allFigures)
                currentFig = allFigures(fi);
                oldName = get(currentFig, 'Name');
                set(currentFig, 'Name', searchedName); forceGuiUpdate();
                if (strfind(char(thisFigure.getTitle()), searchedName))
                    fig = currentFig; 
                end
                set(currentFig, 'Name', oldName); forceGuiUpdate();
                if (~isempty(fig)), break; end
            end

        catch
            fig = [];
        end        
    end
%]
end
function [] = forceGuiUpdate()
%[
    try
        drawnow nocallbacks; 
    catch
        drawnow; % Force update (not sure 'nocallbacks' option was introduced very recently ...) 
    end
%]
end

%% ---
function [] = moveguiex(h, positionDescription, varargin)
%[
    % Check arguments
    if (nargin < 2), error('Not enough input arguments.'); end
    if (~ischar(positionDescription)), error('Invalid position identifier.'); end
    if (~ishandle(h)), error('Invalid graphic handle.'); end

    % 'CenterOf'
    if (strcmpi(strtrim(positionDescription), 'CenterOf') || ...
        strcmpi(strtrim(positionDescription), 'Over'))

        % Additional checks
        if (nargin < 3), error('Not enough input arguments.'); end
        if (nargin ~= 3), error('Too many input arguments.'); end
        p = varargin{1}; if (~ishandle(p)), error('Invalid graphic handle.'); end

        % Work
        if (isempty(p))
            pp = get(0,'screensize'); pl = pp(1); pb = pp(2); pw = pp(3); ph = pp(4); 
        else
            pp = getpixelposition(p); pl = pp(1); pb = pp(2); pw = pp(3); ph = pp(4); 
        end
        tp = getpixelposition(h); tw = tp(3); th = tp(4);

        switch(lower(strtrim(positionDescription)))
            case 'centerof',
                tl = pl + (1/2)*(pw - tw);
                tb = pb + (1/2)*(ph - th);
            case 'over',
                tl = pl + (1/2)*(pw - tw);
                tb = pb + (2/3)*(ph - th);
            otherwise,
                error('Out of range');
        end
        setpixelposition(h, [tl tb tw th]);

        % End
        return;

    end

    % Oops
    error('Position = `%s` is not supported', positionDescription);
%]
end