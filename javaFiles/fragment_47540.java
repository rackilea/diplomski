dependencies:
  pre:
    # Install JQ - used when fetching automation artifacts
    - sudo apt-get update; sudo apt-get install jq
    - curl "https://circleci.com/api/v1.1/project/github/:org/:project/latest/artifacts?build=master&filter=successful&circle-token=$TOKEN" >> artifacts.txt
    - mkdir -p $HOME/automation
  post:
    # Fetch our UI automation jar
    - echo export ART_URL=$(cat artifacts.txt | jq '[.[]? | select(.url | contains("automation-ui-all.jar"))][0] | .url') >> $HOME/.circlerc
    - wget -O $HOME/automation/automation-ui-all.jar $ART_URL?circle-token=$TOKEN