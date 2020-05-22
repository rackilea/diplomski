try {
                String email = binding.get().emailEditText.getText().toString();
                existingUserViewModel.getIsExistingUser().removeObservers(this);
                if (result.body.getExists()) { // user exists
                    navigationController.navigateToLogin(email, null);
                } else {
                    navigationController.navigateToRegisterName(email);
                }
            } catch (NullPointerException e) {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            }