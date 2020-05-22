<div class="itemOthers">
         #set($outputSyntax = $xwiki.getAvailableRendererSyntax('plain', '1.0'))
         #if ($outputSyntax)
           #set ($preview = $xwiki.getDocument($itemfullname).getRenderedContent($outputSyntax))
           #set ($regex = $regextool.quote($request.text))
           #set ($regex_summarize = "(?i)(?:((\w+)\W+){0,20})\b\w*$regex\w*\b(((\W+)\w+){0,20})")
           #set ($regex_highlight = "(?i)($regex)")

           #set ($pattern_summarize = $regextool.compile($regex_summarize))
           #set ($matcher_summarize = $pattern_summarize.matcher($preview))

           #foreach ( $match_loop in [0,1,2,3,4,5,6,7,8,9] )
             #if ($matcher_summarize.find())
               #if ($match_loop > 0)
                <strong> | </strong>
               #end
               $escapetool.html($matcher_summarize.group(0)).replaceAll($regex_highlight,'<span style="background-color:yellow;">$1</span>')
             #end
           #end
         #end
       </div>