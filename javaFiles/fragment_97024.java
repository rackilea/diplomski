%
% PURPOSE:
%
%    Gets handle to current callback control and 
%    handle to the figure containing that control. 
%
% SYNTAX:
%
%    [control] = gcboex();
%    [control, fig] = gcboex();
%
% DESCRIPTION:
%
%    Works exactly the same way as native `gcbo` routine except
%    that it is also working for controls created with `javacomponent`.
% 

%% ---
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