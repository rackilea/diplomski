single_lname returns [String s]
    : p=LNAME_PREFIX? r=NAME { 
        if ($p == null) {
            $s = toNameCase($r.text);
        } else {
            $s = $p.text + toNameCase($r.text);
        }
    }
;