swagger: '2.0'
info: foo
host: adam.noncd.db.de
basePath: /api/v1.0
schemes:
  - https
consumes:
  - application/json
produces:
  - application/json
paths:

  /facilities:
    get:
      description: Access to the facilities known to the system
      operationId: findFacilities
      produces:
        - application/json
      parameters:
        - name: type
          in: query
          description: type of the facility to filter by
          default: ["ESCALATOR", "ELEVATOR"]
          required: false
          type: array
          items:
            $ref: "#/definitions/types_enum"
          collectionFormat: csv
          uniqueItems: true
        - name: state
          in: query
          description: the state of the facility to filter by
          default: ["ACTIVE", "INACTIVE", "UNKNOWN"]
          required: false
          type: array
          items:
            $ref: "#/definitions/states_enum"
          collectionFormat: csv
          uniqueItems: true

      responses:
        '200':
          description: facility data
          schema:
            type: array
            items:
              $ref: '#/definitions/facility'
        '400':
          description: The given filters contained invalid values.
        '406':
          description: The requested representation format is not available.
        '500':
          description: A processing error has occurred.
        '503':
          description: The service has been disabled temporarily.


  '/facilities/{equipmentnumber}':
    get:
      description: Returns the facility identify by equipmentnumber
      operationId: getFacilityByEquipmentNumber
      produces:
        - application/json
      parameters:
        - name: equipmentnumber
          in: path
          description: equipmentnumber of the facility to fetch
          required: true
          type: integer
          format: int64
          minimum: 1
      responses:
        '200':
          description: Facility data
          schema:
            $ref: '#/definitions/facility'
        '404':
          description: The requested facility could not be found.
        '406':
          description: The requested representation format is not available.
        '500':
          description: A processing error has occurred.
        '503':
          description: The service has been disabled temporarily.

  '/stations/{stationnumber}':
    get:
      description: Returns the railway station identified by stationnumber
      operationId: findStationByStationNumber
      produces:
        - application/json
      parameters:
        - name: stationnumber
          in: path
          description: stationnumber of the station to fetch
          required: true
          type: integer
          format: int64
          minimum: 1
      responses:
        '200':
          description: station data
          schema:
            $ref: '#/definitions/station'
        '406':
          description: Requested representation format is not available.
        '500':
          description: A processing error has occurred.
        '503':
          description: The service has been disabled temporarily.            

definitions:

  states_enum:
    type: string
    enum: ["ACTIVE", "INACTIVE", "UNKNOWN"]

  types_enum:
    type: string
    enum: ["ESCALATOR", "ELEVATOR"]

  station:
     type: object
     required:
       - stationnumber
       - name
     properties:
      stationnumber:
        type: integer
        format: int64
        description: "Identification number of the station"
      name:
        type: string
        description: "Name of the station"
      facilities:
        type: array
        items:
          $ref: '#/definitions/facility'

  facility:
    type: object
    required:
      - equipmentnumber
      - type
      - state
      - stationnumber
    properties:
      equipmentnumber:
        type: integer
        format: int64
      'type':
        $ref: "#/definitions/types_enum"
      'description':
        type: string
        description: Textual description of place
      geocoordX:
        type: number
        format: double
        description: geocoordinate component in DB REF format
      geocoordY:
        type: number
        format: double
        description: geocoordinate component in DB REF format
      state:
        $ref: "#/definitions/states_enum"
      stationnumber:
        type: integer
        format: int64