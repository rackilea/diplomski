public static string CleanEmail(string input)
    {
        string output = "";

        try
        {
            if (input.Length > 0)
            {
                string first_pass = Regex.Replace(input, @"[^\w\.@-]", "");
                List<string> second_pass = new List<string>();
                string third_pass = first_pass;
                string final_pass = "";

                if (first_pass.Contains("@"))
                {
                    second_pass = first_pass.Split('@').ToList();

                    if (second_pass.Count >= 2)
                    {
                        string second_pass_0 = second_pass[0];
                        string second_pass_1 = second_pass[1];

                        third_pass = second_pass_0 + "@" + second_pass_1;

                        second_pass.Remove(second_pass_0);
                        second_pass.Remove(second_pass_1);
                    }
                }

                if (second_pass.Count > 0)
                {
                    final_pass = third_pass + string.Join("", second_pass.ToArray());
                }
                else
                {
                    final_pass = third_pass;
                }

                output = final_pass;

            }
        }
        catch (Exception Ex)
        {

        }

        return output;
    }