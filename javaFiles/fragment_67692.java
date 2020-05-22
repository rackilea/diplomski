{
    "created": 1326853478,
    "livemode": false,
    "id": "evt_00000000000000",
    "type": "invoice.upcoming",
    "object": "event",
    "request": null,
    "pending_webhooks": 1,
    "api_version": "2017-06-05",
    "data": {
      "object": {
        "id": null,
        "object": "invoice",
        "amount_due": 0,
        "application_fee": null,
        "attempt_count": 0,
        "attempted": true,
        "charge": null,
        "closed": true,
        "currency": "jpy",
        "customer": "cus_00000000000000",
        "date": 1503541536,
        "description": null,
        "discount": null,
        "ending_balance": 0,
        "forgiven": false,
        "lines": {
          "data": [
            {
              "id": "sub_BN5yNiTkAlQOye",
              "object": "line_item",
              "amount": 500,
              "currency": "jpy",
              "description": null,
              "discountable": true,
              "livemode": true,
              "metadata": {
              },
              "period": {
                "start": 1507604796,
                "end": 1510283196
              },
              "plan": {
                "id": "bplan",
                "object": "plan",
                "amount": 500,
                "created": 1504352393,
                "currency": "jpy",
                "interval": "month",
                "interval_count": 1,
                "livemode": false,
                "metadata": {
                },
                "name": "B plan",
                "statement_descriptor": null,
                "trial_period_days": null
              },
              "proration": false,
              "quantity": 1,
              "subscription": null,
              "subscription_item": "si_1B0LmKE9P3qCpf5erqbpMxkI",
              "type": "subscription"
            }
          ],
          "total_count": 1,
          "object": "list",
          "url": "/v1/invoices/in_1AuB2KE9P3qCpf5ekFh7qpAi/lines"
        },
        "livemode": false,
        "metadata": {
        },
        "next_payment_attempt": null,
        "paid": true,
        "period_end": 1503541536,
        "period_start": 1503541536,
        "receipt_number": null,
        "starting_balance": 0,
        "statement_descriptor": null,
        "subscription": "sub_00000000000000",
        "subtotal": 0,
        "tax": null,
        "tax_percent": null,
        "total": 0,
        "webhooks_delivered_at": 1503541537
      }
    }
  }