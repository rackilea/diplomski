ApiClient apiClient = new ApiClient();

//Override the default API base path configured in Maven
apiClient.setBasePath("http://api.example.com/api");

EmployeeManagementSystemApi api = new EmployeeManagementSystemApi(apiClient);
api.getEmployeeById(1l);