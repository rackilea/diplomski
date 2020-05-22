String sql="SELECT GROUP_CONCAT(module_id) AS module_id
         FROM sox_customer_partner_modules "
      + "WHERE customer_id= :customer_id
         AND partner_id= :partner_id
         AND STATUS='1' 
         GROUP BY customer_id, partner_id";