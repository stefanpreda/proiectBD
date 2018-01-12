# proiectBD

# POSTGRES

TO RUN THE SCRIPT:
sudo -u postgres psql < configure_database.sql

TO CONNECT WITH USER TO DATABASE:
sudo -u postgres psql -U airbnb_user -h 127.0.0.1 -d airbnb

TO DISPLAY TABLES USE:
\dt

TO VIEW TABLE STRUCTURE:
\d+ airbnb_data
