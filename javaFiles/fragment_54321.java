{
    "status": 200,
    "success": "true",
    "data": {
        "works_node": [{
            "works_items": [{
                "work_id": "number",
                "preference": "number",
                "Task_created_time": "datetime yyyy-mm-dd h:m:s"
            }]
        }],
        "questions_node": [{
            "questions_items": [{
                "q_id": "number",
                "work_id": "number",
                "question_text": "string",
                "preference": "number"
            }]
        }],
        "answers_node": [{
            "answers_items": [{
                "a_id": "number",
                "q_id": "number",
                "answer_text": "string",
                "prefernce": "number",
                "point": "number",
                "is_suggest": "number",
                "work_id": "number"
            }]
        }],
        "answer_suggestions_node": [{
            "answer_suggestions_items": [{
                "a_id": "number",
                "q_id": "number",
                "answer_suggestion_text": "string",
                "point": "number",
                "work_id": "number"
            }]
        }]
    }
}