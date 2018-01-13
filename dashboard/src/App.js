import React, { Component } from 'react';
import { Legend, ResponsiveContainer, BarChart, Bar } from 'recharts';
import './App.css';

const barChartData= [{
  column1:1,
  column2: 2,
  column3: 3,
}]

class App extends Component {
  render() {
    return (
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title"> Counts</h4>
                <h6 class="card-subtitle mb-2 text-muted">Graph1</h6>
                  <ResponsiveContainer width='50%' aspect={6.0/4.0}>
						        <BarChart data={barChartData} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                            <Bar dataKey='column1' fill='#83a754'/>
                            <Bar dataKey='column2' fill='#cecece'/>
                            <Bar dataKey='column3' fill='#da5d2c'/>		    
						          <Legend/>						
						        </BarChart>
                  </ResponsiveContainer>
              </div>
            </div>
          </div>
          <div class="col-sm-6">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title">Languages</h4>
                <h6 class="card-subtitle mb-2 text-muted">Graph2</h6>
                  <ResponsiveContainer width='50%' aspect={6.0/4.0}>
						        <BarChart data={barChartData} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                            <Bar dataKey='column1' fill='#83a754'/>
                            <Bar dataKey='column2' fill='#cecece'/>
                            <Bar dataKey='column3' fill='#da5d2c'/>		    
						          <Legend/>						
						        </BarChart>
                  </ResponsiveContainer>
              </div>
            </div>
          </div>
        </div>
      </div>

    );
  }
}

export default App;
