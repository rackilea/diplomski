---

- hosts: localhost
  gather_facts: False

  tasks:
   - name: Fetch Java version
     shell: java -version 2>&1 | grep version | awk '{print $3}' | sed 's/"//g'                                                                                                                                   
     changed_when: False
     register: java_result

   - debug:
       msg: "{{ java_result.stdout }}"