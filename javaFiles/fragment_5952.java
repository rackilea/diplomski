cooldown = (data.find(({ distance: d }) => distance <= d) || {}).cooldown;
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^                  find object
//                     ^^^^^^^^^^^^^^^                                     destructuring
//                                         ^^^^^^^^^^^^^                   condition
//                                                           ^^            default value
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^           check result
//                                                               ^^^^^^^^  final value