<ul>
{{#items}}
{{#each .}}
{{#if .}}
  <li><a href="#{{@key}}">{{@key}}</a></li>
{{else}}
  <li class="unused-letter">{{@key}}</li>
{{/if}}
{{/each}}
{{/items}}
</ul>