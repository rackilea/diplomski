if ((input.charAt (pos) == '$')
            && (Character.isDigit (input.charAt (pos + 1))))
          {
            // Omitted code parses the group number into val
            ...

            if (val < start.length)
              {
                output.append (toString (val));
              }
          }