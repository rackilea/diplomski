/**
 * @api {get} /authenticate/user?
 * @apiName Authenticator
 * @apiGroup Authentication
 *
 * @apiDescription Authenticate a user
 *
 * @apiSampleRequest /authenticate/user
 *
 * @apiParam    {String}            username                    User name
 * @apiParam    {String}            password                    User password
 *
 * @apiSuccess  {JSONObject}        user                        User
 *
 * @apiExample Success-Response (example):
 *     {
 *       ...
 *     }
 *
 * @apiExample Error-Response (example):
 *     {
 *          ...
 *     }
 */

/**
 * @api {get} /authenticate/app?
 * @apiName Authenticator
 * @apiGroup Authentication
 *
 * @apiDescription Authenticate an app
 *
 * @apiSampleRequest /authenticate/app
 *
 * @apiParam    {String}            appId                   App Id
 * @apiParam    {String}            appKey                  Secret Key
 *
 * @apiSuccess  {JSONObject}        app                     App
 *
 * @apiExample Success-Response (example):
 *     {
 *       ...
 *     }
 *
 * @apiExample Error-Response (example):
 *     {
 *          ...
 *     }
 */