import com.intellij.psi.*;
for (PsiClass aClass : X.getSupers()) { // X refers to the template var $X$
  for (PsiField field : aClass.getAllFields()) {
    // compares the type of the super field with the type of field $a$
    if (field.getType().equals(a.getType())) {
      return true;
    }
  }
}
return false;