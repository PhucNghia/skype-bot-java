# Hướng dẫn tích hợp Bot 
## Bước 1. Tạo bot framework 
link tạo: https://dev.botframework.com/bots/new

## Bước 2. Tạo App registration trên Azure
* Tạo App để lấy giá trị App ID
* Gen Certificates & Secrets để lấy giá tị Value
* Lưu 2 giá trị trên vào file application.properties <br>
  MicrosoftAppId = "App ID"<br>
  MicrosoftAppPassword = "Value"
* **lưu ý**: expire time của value tối đa là 2 năm. cần phải gen lại nếu hết hạn

## Bước 3. Thêm Bot vào group
* đọc log trên BE để lấy group ID

## Bước 4. Gọi API để gửi message tới Bot
* Thông tin API như sau: <br>
  POST: {{base_url}}/api/notification<br>
  BODY:<br>
  {<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "conversationId": "19:0c9616cf33a24c2d8894ffe3a9c64785@thread.skype",<br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "body": "hello"<br>
  }

#### Link hướng dẫn tích hợp: 


