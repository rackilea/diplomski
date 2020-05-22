public function get_key_and_iv($key, $salt, $reps) {
    $hash = $key . $salt;
    for ($i = 0; $i< $reps; $i++) {
      $hash = md5($hash, TRUE);
    }
    return str_split($hash,8);
  }